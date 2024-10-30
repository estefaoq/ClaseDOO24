package co.edu.uco.crosscutting.helpers;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.crosscutting.exceptions.UcoApplicationException;
import co.edu.uco.crosscutting.exceptions.enums.Layer;

public final  class SqlConnectionHelper {
	private SqlConnectionHelper() {
		
	}
	public static boolean connectionIsNull(final Connection connection) {
		return ObjectHelper.isNull(connection);
		
	}
	public static boolean connectionIsOpen(final Connection connection) {
		try {
		return !connectionIsNull(connection) && !connection.isClosed();
		}catch(final SQLException e) {
		   var userMessage = "se ha presentado un problema inesperado tratando de" + "llevar a cabo la validacion de si la conexion" + "estaba abierta o no abierta. porfavor revise el log de errores para" + "mas detalle del error presentado...";
		   throw new UcoApplicationException(userMessage, technicalMessage, exception, Layer.DATA);
		}
	}
	

}
