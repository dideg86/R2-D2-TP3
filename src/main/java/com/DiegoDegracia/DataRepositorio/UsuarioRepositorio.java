package com.DiegoDegracia.DataRepositorio;

import com.DiegoDegracia.DataRepositorio.Connection.ConexionSQLlite;
import com.DiegoDegracia.DataRepositorio.RepoInterno.UsuarioRepoInterno;
import com.DiegoDegracia.Modelos.Repositorios.IUsuarioRepositorio;
import com.DiegoDegracia.Modelos.Usuario;

import java.sql.Connection;
import java.util.List;

public class UsuarioRepositorio implements IUsuarioRepositorio {

    @Override
    public List<Usuario> Obtener() {
        Connection conn = ConexionSQLlite.NuevaConexion();
        return UsuarioRepoInterno.Obtener(conn);
    }

    @Override
    public Usuario Obtener(int usuarioId) {
        Connection conn = ConexionSQLlite.NuevaConexion();
        return UsuarioRepoInterno.Obtener(usuarioId, conn);
    }

    @Override
    public void Crear(Usuario usuario) {
        Connection conn = ConexionSQLlite.NuevaConexion();
        UsuarioRepoInterno.Crear(usuario, conn);
    }

    @Override
    public void Actualizar(Usuario usuario) {

    }
}
