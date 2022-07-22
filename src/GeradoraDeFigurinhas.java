import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo ) throws Exception{

        // leitura da imagemf
        // InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
        // InputStream inputStream = new URL("https://www.jornalcontabil.com.br/wp-content/uploads/2017/01/business-people-looking-at-clock-600x400.jpg").openStream();
       
        BufferedImage imagem = ImageIO.read(inputStream);
        
        // cria nova imagem em memoria com transparencia e com tamanho novo
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        int novaAltura = altura + 100;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        // copiar a imagem original pra nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagem, 0, 0, null);

        //configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        graphics.setFont(fonte);
        graphics.setColor(Color.PINK);

        // escrever uma frase na nova imagem
        graphics.drawString("Vai Trabaia", 10, novaAltura - 60);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
