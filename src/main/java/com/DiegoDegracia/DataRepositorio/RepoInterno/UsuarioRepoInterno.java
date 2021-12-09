package com.DiegoDegracia.DataRepositorio.RepoInterno;

import com.DiegoDegracia.Modelos.TipoAventura;
import com.DiegoDegracia.Modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepoInterno {
    // Consultas SQL
    private static String OBTENER_USUARIOS = "SELECT * FROM usuarios";
    private static String OBTENER_POR_ID = "SELECT * FROM usuarios WHERE usr_id = ?";
    private static String CREAR_USUARIO = """
                                        INSERT INTO
                                        usuarios(usr_nom, usr_cod_ave, usr_pre, usr_tie_disp)
                                        VALUES (?, ?, ?, ?)""";
    private static String ActualizarUsuario = """
                                            UPDATE usuario
                                            SET
                                                usr_nom = ?,
                                                usr_cod_ave = ?,
                                                usr_pre = ?,
                                                usr_tie_disp = ?
                                            WHERE
                                                usr_id = ?""";

    public static List<Usuario> Obtener(Connection conn) {
        List<Usuario> ret = new ArrayList<Usuario>();

        try{
            PreparedStatement stm = conn.prepareStatement(OBTENER_USUARIOS);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usr_id");
                String nombre = rs.getString("usr_nom");
                int presupuesto = rs.getInt("usr_pre");
                double tiempoDisponible = rs.getDouble("usr_tie_disp");
                int preferenciaTipoAventura = rs.getShort("usr_cod_ave");

                Usuario usr = new Usuario(id, nombre, TipoAventura.values()[preferenciaTipoAventura], presupuesto, tiempoDisponible);
                ret.add(usr);
            }

            stm.close();
        }catch (SQLException e){
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException ex){
                    throw  new Error(ex);
                }
            }
            throw  new Error(e);
        }

        return ret;
    }
    public static Usuario Obtener(int usuarioId, Connection conn) {
        Usuario ret = null;

        try{
            PreparedStatement stm = conn.prepareStatement(OBTENER_POR_ID);
            stm.setInt(1, usuarioId);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("usr_id");
                String nombre = rs.getString("usr_nom");
                int presupuesto = rs.getInt("usr_pre");
                double tiempoDisponible = rs.getDouble("usr_tie_disp");
                int preferenciaTipoAventura = rs.getShort("usr_cod_ave");

                ret = new Usuario(id, nombre, TipoAventura.values()[preferenciaTipoAventura], presupuesto, tiempoDisponible);
            }
            stm.close();
        }catch (SQLException e){
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException ex){
                    throw  new Error(ex);
                }
            }
            throw  new Error(e);
        }
        return ret;
    }
    public static void Crear(Usuario usuario, Connection conn) {
        try{
            PreparedStatement stm = conn.prepareStatement(CREAR_USUARIO);
            stm.setString(1, usuario.getNombre());
            stm.setShort(2, (short) usuario.getPreferencia().ordinal());
            stm.setInt(3, usuario.getPresupuesto());
            stm.setDouble(4,usuario.getTiempoDisponible());

            stm.execute();
        }catch (SQLException e){
            throw new Error(e);
        }
    }
}
