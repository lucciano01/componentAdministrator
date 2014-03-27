/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.componente.admin.servlet;

import br.edu.ifpb.componente.adm.business.UsuarioBusiness;
import br.edu.ifpb.componenteadmin.entidade.Usuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




/**
 *
 * @author Luciano
 */

    

public class UsuarioServlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
    
    private final String UPLOAD_DIRECTORY = "D:/upload";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
        UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
        
         DiskFileItemFactory df = new DiskFileItemFactory();
        ServletFileUpload sf = new ServletFileUpload(df);
        try {
            List items = sf.parseRequest(request);
            
            FileItem name = (FileItem) items.get(0);
            FileItem cpf_user = (FileItem) items.get(1);
            FileItem email_user = (FileItem) items.get(2);
            FileItem tif_user = (FileItem) items.get(3);
            FileItem img1 = (FileItem) items.get(4);
            FileItem img2 = (FileItem) items.get(5);
            FileItem img3 = (FileItem) items.get(6);
            FileItem img4 = (FileItem) items.get(7);
            
            String nome = name.getString();
            String cpf = cpf_user.getString();
            String email = email_user.getString();
            String tif = tif_user.getString();
            
            
            byte [] imagem1 = read(img1);
            byte [] imagem2 = read(img2);
            byte [] imagem3 = read(img3);
            byte [] imagem4 = read(img4);
            
            Usuario u = new Usuario();
            u.setNome(nome);
            u.setCpf(cpf);
            u.setEmail(email);
            u.setTif(tif);
            u.setImagem1(scale(imagem1, 600 , 480));
            u.setImagem2(scale(imagem2, 600 , 480));
            u.setImagem3(scale(imagem3, 600 , 480));
            u.setImagem4(scale(imagem4, 600 , 480));
            System.out.println(u.getImagem1());
            usuarioBusiness.save(u);
            
            
            
        } catch (FileUploadException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
  
                  
        
      /* Aqui é feito o upload da imagem para um diretorio temporario 
        if (ServletFileUpload.isMultipartContent(request)) {

            List<FileItem> multiparts;
            try {
                multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                InputStream input;
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                //
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                      String name = new File(item.getName()).getName();
                        //
                        input = item.getInputStream();
                        //
                        byte[] b = new byte[1024];
                        while (input.read(b) != -1) {
                            output.write(b);
                        }
                        //criar o descritor do arquivo
                        FileOutputStream outfile = new FileOutputStream(
                                new File(UPLOAD_DIRECTORY + File.separator + name));
                        //escrever os bytes no arquivo
                        output.writeTo(outfile);
                    }
                }
            } catch (FileUploadException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            /* A partir daqui é capturado informações sobre o arquivo 
             * como diretorio, nome é extraido seus bytes, convetido
             * em xml usando JAX-WS e sumedido ao serviço REST
             

            File file = new File(UPLOAD_DIRECTORY + File.separator + name);


            if (file.exists()) {

                long l = file.length();

                byte[] d = new byte[(int) l];

                FileInputStream in = new FileInputStream(file);
                in.read(d);
                in.close();

                byte[] a = scale(d, 600, 480);

                 Deletando os arquivos do diretorio temporário 
                File folder = new File(UPLOAD_DIRECTORY);
                if (folder.isDirectory()) {
                    File[] sun = folder.listFiles();
                    for (File toDelete : sun) {
                        toDelete.delete();
                    }
                }

                String imagemB64 = Base64.encodeBytes(a);

                ImageBean img = new ImageBean();
                img.setImage(imagemB64);

                ByteArrayOutputStream out = new ByteArrayOutputStream();

                /* convertendo os bytes da imagem em xml via JAX-WS 

                try {
                    JAXBContext ctx = JAXBContext.newInstance(ImageBean.class);
                    Marshaller marshaller = ctx.createMarshaller();
                    marshaller.marshal(img, out);
                } catch (JAXBException ex) {
                    Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                String ImagemStringBytes = new String(out.toByteArray());

                StringRepresentation ImagemXml = new StringRepresentation(
                        ImagemStringBytes, MediaType.APPLICATION_XML);
                /* Aqui existe a chamada para o serviço de Ari 
                
                
                
           
                ClientResource client = new ClientResource("http://10.1.1.102:9191/xml/upload");
                Representation resposta = client.post(ImagemXml);
                if (resposta != null) {
                    String tif = resposta.getText();


                    /* Como existe um número máximo de threads para a requsição
                     aqui é preciso dispensar o cliente com .stop()
                     
                    Client c = (Client) client.getNext();
                    try {
                        c.stop();
                    } catch (Exception e) {
                        request.setAttribute("message", e.getMessage());
                    }

                    /* Baseado na reposta do serviço REST é gerado o token de acesso ou não
                     * e presistido no banco 
                    try {

                        String tokenAcess = autenticatirBean.getAcessToken();
                        request.setAttribute("ta", tokenAcess);
                        request.setAttribute("tif", tif);

                        AutenticatorDAO aDAO = new AutenticatorDAO();
                        aDAO.tokensPersist(tif, tokenAcess);
                        resp2.tokenGeneratorService(tokenAcess, tif);
                        request.setAttribute("token", tokenAcess);

                    } catch (Exception ex) {
                        Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else { //se a resposta do serviço REST for NULL
                    request.setAttribute("message", "A foto não foi reconhecida!");
                    try {
                        resp2.tokenGeneratorService(null, null);
                    } catch (Exception ex) {
                        Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            request.getRequestDispatcher("/resultado.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Erro no upload da foto!");
            request.getRequestDispatcher("/erro.jsp").forward(request, response);*/
   
     }
    
     public byte[] read(FileItem fi) throws IOException{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream is = fi.getInputStream();
        int read = 0;
        final byte[] b = new byte[1024];

        while ((read = is.read(b)) != -1) {
            out.write(b, 0, read);
        }
        return out.toByteArray();
    }
    
    public byte[] scale(byte[] fileData, int width, int height) {
		ByteArrayInputStream in = new ByteArrayInputStream(fileData);
		try {
			BufferedImage img = ImageIO.read(in);
			if (height == 0) {
				height = (width * img.getHeight()) / img.getWidth();
			}
			if (width == 0) {
				width = (height * img.getWidth()) / img.getHeight();
			}
			Image scaledImage = img.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			BufferedImage imageBuff = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			imageBuff.getGraphics().drawImage(scaledImage, 0, 0,
					new Color(0, 0, 0), null);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			ImageIO.write(imageBuff, "jpg", buffer);
			return buffer.toByteArray();
		} catch (IOException e) {
			return null;
		}
    }
    }
       

  


        
        
        
        
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
