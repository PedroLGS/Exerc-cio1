package view;

import controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		RedesController pCont = new RedesController();
     	pCont.os();
		
		String process = "PING -4 -n 10 www.google.com.br";
		pCont.readTraceRoute(process);

	}

}