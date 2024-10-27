package com.easyrents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    // Logger para registrar mensajes e información
    private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class.getName());

    // Método para guardar un usuario en la base de datos
    public void guardarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (id, nombre, correo, contraseña, tipo_usuario, numnumDocLicencia, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        // Uso de try-with-resources para manejar conexión y PreparedStatement
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
             
            // Asignar parámetros de la consulta SQL
            stmt.setInt(1, usuario.getID());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getContraseña());
            stmt.setString(5, usuario.getTipoUsuario());
            stmt.setLong(6, usuario.getNumDocLicencia());
            stmt.setInt(7, usuario.getTelefono());
            
            // Ejecutar la consulta de inserción
            stmt.executeUpdate();
            LOGGER.log(Level.INFO, "Usuario guardado con éxito: {0}", usuario.getCorreo());
            
        } catch (SQLException e) {
            // Log de error con nivel SEVERE
            LOGGER.log(Level.SEVERE, "Error al guardar el usuario: {0}", e.getMessage());
            
            // Propagar la excepción para que sea manejada en niveles superiores
            throw e;
        }
    }

    // Método para obtener un usuario por correo electrónico
    public Usuario obtenerUsuarioPorCorreo(String correo) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE correo = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
             
            // Asignar el parámetro para la búsqueda
            stmt.setString(1, correo);
            
            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmt.executeQuery();
            
            // Si se encuentra un usuario, devolver un objeto Usuario
            if (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contraseña"),
                    rs.getString("tipo_usuario"),
                    rs.getLong("numDocLicencia"),
                    rs.getInt("telefono")
                );
                LOGGER.log(Level.INFO, "Usuario obtenido con éxito: {0}", correo);
                return usuario;
            } else {
                LOGGER.log(Level.WARNING, "No se encontró el usuario con correo: {0}", correo);
            }
        } catch (SQLException e) {
            // Log de error con nivel SEVERE
            LOGGER.log(Level.SEVERE, "Error al obtener el usuario por correo: {0}", e.getMessage());
            
            // Propagar la excepción para que sea manejada en niveles superiores
            throw e;
        }
        
        // Retorna null si no se encontró el usuario
        return null;
    }
}
