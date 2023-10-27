package quest03_Bruna;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Picture {
	public static void main(String[] args) {
        try {
            
            BufferedImage imagem = ImageIO.read(new File("C:\\Users\\bruna\\Downloads\\caverna.jpg"));

            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o ajuste de brilho (-255 a 255): ");
            int ajusteBrilho = scanner.nextInt();

            
            ajusteBrilho = Math.max(-255, Math.min(255, ajusteBrilho));

           
            for (int y = 0; y < imagem.getHeight(); y++) {
                for (int x = 0; x < imagem.getWidth(); x++) {
                    int cor = imagem.getRGB(x, y);

                    int vermelho = (cor >> 16) & 0xFF;
                    int verde = (cor >> 8) & 0xFF;
                    int azul = cor & 0xFF;

               
                    vermelho = Math.max(0, Math.min(255, vermelho + ajusteBrilho));
                    verde = Math.max(0, Math.min(255, verde + ajusteBrilho));
                    azul = Math.max(0, Math.min(255, azul + ajusteBrilho));

                   
                    int novaCor =  (vermelho << 16) | (verde << 8) | azul;

                    imagem.setRGB(x, y, novaCor);
                }
            }

            
            ImageIO.write(imagem, "jpg", new File("C:\\Users\\bruna\\Downloads\\caverna_brilho_ajustado.jpg"));

            System.out.println("O brilho da imagem foi ajustado com sucesso!");

            
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
