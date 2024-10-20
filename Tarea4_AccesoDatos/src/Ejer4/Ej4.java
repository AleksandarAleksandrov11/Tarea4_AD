package Ejer4;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * La clase Ej4 permite crear registros de alumnos pidiendo la información
 * al usuario para posteriormente guardarla en un archivo binario con el nombre
 * y la ruta proporcionada por el usuario.
 * 
 * 
 * @author Aleksandar Aleksandrov
 */
public class Ej4 {

    /**
     * El método main maneja la entrada del usuario y 
     * escribe los registros de los alumnos en un archivo binario.
     * 
     * 
     * @param ruta La ruta y el nombre del archivo binario.
     * @throws ParseException Si hay un error en la fecha de nacimiento.
     */
    public static void main(String[] args) throws ParseException {
        
            Scanner sc = new Scanner(System.in);
            String ruta;
            System.out.println("Dime la ruta y el nombre del archivo binario");
            ruta = sc.nextLine();
            
            DataOutputStream dop = null;
            
            try {
				dop = new DataOutputStream(new FileOutputStream(ruta));
				
	            for (int i = 0; i < 6; i++) {
	            	
	            	Alumno a = new Alumno();
	            	a.leerAlumnos(sc,i);
	            	
	            	dop.writeInt(a.getNia());
	            	dop.writeUTF(a.getNombre());
	            	dop.writeUTF(a.getApellidos());
	            	dop.writeChar(a.getGenero());
	            	dop.writeLong(a.getfNacimiento().getTime());
	            	dop.writeUTF(a.getCiclo());
	            	dop.writeUTF(a.getCurso());
	            	dop.writeUTF(a.getGrupo());
	            	
	            	
	            	
	            }
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(dop!=null) {

					dop.close();
					
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
            


            sc.close();

    }
}