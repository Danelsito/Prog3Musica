package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import libraries.Conexion;
import model.Song;

//Esta clase gestiona la conexión con playlistdat.dat que se encarga de los archivos .mp3 de la aplicación
public class SongDAO {
    
    List<Song> songs=null;
    private ObjectInputStream readConexion;
    private ObjectOutputStream writeConexion;
    private Conexion conn=null;
    
    //ObjectOutputStream
    
    public SongDAO(){
        conn = new Conexion();
        songs = new LinkedList<>();
    }
    //método que elimina la canción de la lista y luego crea una conexión para actualizar el archivo.
    public void deleteSong(List<Song> musics, int idSong){
        
        try {
            musics.remove(idSong);
            
            writeConexion = conn.getWriteConexion();
            
            writeConexion.writeObject(musics);
            
            conn.closeWriteConexion(writeConexion);
        } catch (IOException ex) {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //similar al método anterior pero hace un vaciado completo de golpe
    public void deleteAllSongs(List<Song> musics){
        musics.removeAll(musics);
        try {
            FileOutputStream file =new FileOutputStream("playListData.dat");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //métido para primero añadir canciones a la lista de reproducción y luego actualizar el archivo.
    public void insertSongs(List<Song> s){
        try {
            writeConexion = conn.getWriteConexion();
            writeConexion.writeObject(s);
            
            conn.closeWriteConexion(writeConexion);
        } catch (IOException ex) {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo que devuelve la lista de canciones en el archivo
    public List<Song> getSongs(){
        readConexion = conn.getReadConexion();

        try {
            if(readConexion!=null){
                System.out.println("dentro de songDAO, tiene archivos");
                songs = (List<Song>) readConexion.readObject();
                conn.closeReadConexion(readConexion);
               return songs;
            }else{
                System.out.println("dentro de songDAO, no tiene archivos");
                return null;
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
}
