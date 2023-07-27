package classes;
import java.io.InputStream;
import javax.sound.sampled.*;


public class SoundEffect implements Runnable { //interface que contém métodos vazios
	//contém método Run 

	// Atributos
	private String audioPath; //guarda o caminho do arquivo
	private boolean loop; //loop para a música de fundo

    public SoundEffect(String audioPath, boolean loop) {
        this.audioPath = audioPath;
        this.loop = loop;
    }
    
    public void play() {
    	Thread t= new Thread(this); //this é o o bjeto que foi criado dentro do método
    	t.start();
    }
    
    //métodos específicos - apenas void run()
    @Override
    public void run() { //reproduz somente arquivos .wav 
        try {
            // Inicia a reprodução em loop infinito
            do{
                // Cria um novo fluxo de entrada de áudio a partir do arquivo original
                InputStream inputStream = SoundEffect.class.getResourceAsStream(audioPath); //sai da classe e procura o arquivo para ler
                AudioInputStream copiedStream = AudioSystem.getAudioInputStream(inputStream); //cria uma cópia, pois é um loop e n funciona o original

                // Obtém o formato de áudio do arquivo .wav
                AudioFormat audioFormat = copiedStream.getFormat();

                // Cria um DataLine.Info para a linha de reprodução
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

                // Obtém a linha de reprodução do sistema
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                
                // Abre novamente a linha de reprodução
                line.open(audioFormat); //audioFormat = .wav

                // Inicia a reprodução
                line.start();

                // Cria um buffer para armazenar os dados do áudio
                byte[] buffer = new byte[4096];
                int bytesRead = 0;

                // Lê dados do áudio do InputStream e escreve na linha de reprodução
                while ((bytesRead = copiedStream.read(buffer)) != -1) {
                    line.write(buffer, 0, bytesRead);
                }

                // Encerra a reprodução
                line.drain();
                line.stop();
                line.close();
                copiedStream.close();
            }while (loop);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    // Métodos de acesso
	public boolean isLoop() { // em vez de getLoop, isLoopt, pois é boolean
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
}
