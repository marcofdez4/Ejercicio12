package ejercicio12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		
		Ciudad c1 = new Ciudad("Barcelona", 100000);
		Ciudad c2 = new Ciudad("Huelva", 200000);
		Ciudad c3 = new Ciudad("Madrid", 1000000);
		Ciudad c4 = new Ciudad("Malaga", 50000);
		Ciudad c5 = new Ciudad("Sevilla", 80000);
		List<Ciudad> ciudades = Arrays.asList(c1, c2, c3, c4, c5);
		
		String nombreProyecto = "Mi proyecto";
		int buildNumero = 1;
		String contenidoJenkinsFile = 
				"pipeline {\n" +
                        "    agent any\n" +
                        "    stages {\n" +
                        "        stage('Build') {\n" +
                        "            steps {\n" +
                        "                script {\n" +
                        "                    echo 'Building " + nombreProyecto + " (Build #" + buildNumero + ")'\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n";
		
		
		for(Ciudad c: ciudades) {
			contenidoJenkinsFile +="        stage('"+c.getNombre()+"') {\n" +
                    				"            steps {\n" +
				                    "                script {\n" +
				                    "                    echo 'Poblacion final de "+c.getNombre()+" es: "+c.calculaPoblacionFinal()+"'\n" +
				                    "                }\n" +
				                    "            }\n" +
				                    "        }\n";
		}

		
		contenidoJenkinsFile += "        stage('Deploy') {\n" +
                        "            steps {\n" +
                        "                script {\n" +
                        "                    echo 'Deployment activo...'\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}";
										  	

		try (
			PrintWriter writer = new PrintWriter(new FileWriter("Jenkinsfile")))
		{
			writer.write(contenidoJenkinsFile);
			System.out.println("Se genero el Jenkinsfile");
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
