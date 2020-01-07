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
    
    public void deleteAllSongs(List<Song> musics){
        musics.removeAll(musics);
        try {
            FileOutputStream file =new FileOutputStream("playListData.dat");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertSongs(List<Song> s){
        try {
            writeConexion = conn.getWriteConexion();
            writeConexion.writeObject(s);
            
            conn.closeWriteConexion(writeConexion);
        } catch (IOException ex) {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Song> getSongs(){
        readConexion = conn.getReadConexion();
//----------------------------------------------------------- falta arreglar esto
        try {
            if(readConexion!=null){
                System.out.println("dentro de songDAO, getsongs.. existe cancionesss");
                songs = (List<Song>) readConexion.readObject();
                conn.closeReadConexion(readConexion);
               return songs;
            }else{
                System.out.println("dentro de songDAO, getsongs. devolvio nulo");
                return null;
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
}
