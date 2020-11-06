package br.com.nutribemrefeicoescoletivas.ftp;

import br.com.nutribemrefeicoescoletivas.bean.ArquivoBean;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.net.ftp.FTPClient;

public class FTPControl {
    private final String servidor;
    private final String usuario;
    private final String senha;
    private final FTPClient ftpClient = new FTPClient();
    
    public FTPControl(String servidorFTP, String usuario, String senha) {
            this.servidor = servidorFTP;
            this.usuario = usuario;
            this.senha = senha;
    }
    
    public boolean connect() throws IOException{
        ftpClient.connect(this.servidor);
        if(ftpClient.login(this.usuario, this.senha)){
            
            ftpClient.setConnectTimeout(7200000);
            ftpClient.setDefaultTimeout(720000);
            ftpClient.setKeepAlive(true);
            ftpClient.setControlKeepAliveReplyTimeout(3000);
            ftpClient.setControlKeepAliveTimeout(10);
            ftpClient.setBufferSize(1024*1024);
            
            System.out.println("Conexão Aceita");  
            
        }else{
            disconnectFTP();
            System.out.println("Conexão recusada");  
            System.exit(1);  
            return false;
        }
        return true;
    }
    public void disconnectFTP() {
        try {
            this.ftpClient.logout();
            this.ftpClient.disconnect();			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean setFile( Object ob ) throws IOException {
        
        ArquivoBean arq = (ArquivoBean) ob;
        
        FileInputStream arqEnviar = null;
        try {
            connect();
            ftpClient.changeWorkingDirectory("ArquivosRH");
            ftpClient.enterLocalActiveMode();
            arqEnviar = new FileInputStream( arq.getCaminho() );
            System.out.println("Iniciando Envio");
        if ( ftpClient.storeFile( arq.getNome() , arqEnviar ) ) {
            System.out.println("Enviado");
            return true;
        }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            arqEnviar.close();
            disconnectFTP();
        }   
      return false;
    }
    public void getFile(String arquivo) {
        try {
            connect();
            ftpClient.changeWorkingDirectory("ArquivosRH");
            ftpClient.setFileType( FTPClient.BINARY_FILE_TYPE );
            ftpClient.enterLocalPassiveMode();
            ftpClient.setAutodetectUTF8(true);
            
            File diretorio = new File("C:/DocsRH");
            
            if(!diretorio.exists()){
                diretorio.mkdir();
            }
            String[] arq = ftpClient.listNames();
            
            //System.out.println("Arquivo Recebido 123");
            
            InputStream is = ftpClient.retrieveFileStream(arquivo);
            
            FileOutputStream os = new FileOutputStream( diretorio + "/" + arquivo);
            
            //Le e grava byte a byte. Voce pode (e deve) usar buffers para
            //melhor performance (BufferedReader).
            int umByte = 0;
            while ((umByte = is.read()) != -1){
                os.write(umByte);
            }

            //Nao se esqueca de sempre fechar as streams apos seu uso!
            is.close();
            os.close();

            File ar = new File("C:/DocsRH/"+ arquivo);
                            
            if(ar.exists()){
                System.out.println("Arquivo Recebido");
            }else{
                System.out.println("Falha ao receber arquivo");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                disconnectFTP();
        }   		
    }
    
    public static File gravaArquivoDeURL(String stringUrl, String pathLocal) {
        try {

                //Encapsula a URL num objeto java.net.URL
                URL url = new URL(stringUrl);

                //Queremos o arquivo local com o mesmo nome descrito na URL
                //Lembrando que o URL.getPath() ira retornar a estrutura 
                //completa de diretorios e voce deve tratar esta String
                //caso nao deseje preservar esta estrutura no seu disco local.
                String nomeArquivoLocal = url.getPath();

                //Cria streams de leitura (este metodo ja faz a conexao)...
                InputStream is = url.openStream();

                //... e de escrita.
                FileOutputStream fos = new FileOutputStream(pathLocal+nomeArquivoLocal);

                //Le e grava byte a byte. Voce pode (e deve) usar buffers para
                //melhor performance (BufferedReader).
                int umByte = 0;
                while ((umByte = is.read()) != -1){
                        fos.write(umByte);
                }

                //Nao se esqueca de sempre fechar as streams apos seu uso!
                is.close();
                 fos.close();

                //apos criar o arquivo fisico, retorna referencia para o mesmo
                return new File(pathLocal+nomeArquivoLocal);

        } catch (Exception e) {
                //Lembre-se de tratar bem suas excecoes, ou elas tambem lhe tratarão mal!
                //Aqui so vamos mostrar o stack no stderr.
                e.printStackTrace();
        }

        return null;
    }
    
}
