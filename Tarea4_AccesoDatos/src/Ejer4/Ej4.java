package Ejer4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) throws ParseException {
		
		try {
			
			Alumno a = new Alumno();
			Scanner sc = new Scanner(System.in);
			String ruta;
			System.out.println("Dime la ruta y el nombre del archivo binario");
			ruta = sc.nextLine();
			
			FileOutputStream fos = new FileOutputStream(ruta);
			
			for (int i = 1; i < 6; i++) {
				
				System.out.println("Dime el nia del alumno "+i);
				a.setNia(sc.nextInt());
				
				System.out.println("Dime el nombre del alumno "+i);
				a.setNombre(sc.next());
				
				System.out.println("Dime los apellidos del alumno "+i);
				a.setApellidos(sc.nextLine());
				sc.nextLine();
				
				System.out.println("Dime el genero del alumno "+i);
				a.setGenero(sc.next().charAt(0));
				sc.nextLine();
				
				System.out.println("Dime la fecha de nacimiento del alumno "+i);
				String fechaFormatoTexto=sc.nextLine();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				a.setfNacimiento(formato.parse(fechaFormatoTexto));
				
				System.out.println("Dime el ciclo del alumno "+i);
				a.setCiclo(sc.next());
				
				System.out.println("Dime el curso del alumno "+i);
				a.setCurso(sc.next());
				
				System.out.println("Dime el grupo del alumno "+i);
				a.setGrupo(sc.next());
				
				String texto = "Alumno "+i+": [NIA-> "+a.getNia()+", NOMBRE-> "+a.getNombre()+", APELLIDOS-> "+a.getApellidos()+", GENERO-> "+a.getGenero()+
						", FechaDeNacimiento-> "+a.getfNacimiento()+", CICLO-> "+a.getCiclo()+", CURSO-> "+a.getCiclo()+", GRUPO-> "+a.getGrupo()+"]\n" ;
				
				byte codigos[] = texto.getBytes();
				
				fos.write(codigos);
				
			}

			
			fos.close();
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
	
	
}
