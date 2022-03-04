package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			System.out.println("É windows");
		}
		if (os.contains("Linux")) {
			System.out.println("É linux");
		}
		return os;
	}

    public void readTraceRoute(String process) {
    		try {
    			Process p = Runtime.getRuntime().exec(process);
    			InputStream fluxo = p.getInputStream();
    			InputStreamReader convString = new InputStreamReader(fluxo);
    			BufferedReader buffer = new BufferedReader(convString);
    			String linha = buffer.readLine();
    			linha = buffer.readLine();
    			linha = buffer.readLine();
    			linha = buffer.readLine();
    			linha = buffer.readLine();
    			while (linha != null) {
    				String[] vetLinha = linha.split("ms");
    				int tamanho = vetLinha.length;
    				String ip = vetLinha[tamanho - 1];
    				
    				if (ip.contains("[")) {
    					String[] vetIp = ip.split("\\[");
    					String newIp = vetIp[1].replace("]", "");
    					System.out.println(newIp);
    				} else {
    					if (!ip.contains("tempo limite")) {
    						System.out.println(ip.trim());
    					}
    				}
    				
    				linha = buffer.readLine();
    				
    			}
    		} catch (IOException e) {
    			System.err.println("Chamada inválida");
    		}
    	}
}
    	
