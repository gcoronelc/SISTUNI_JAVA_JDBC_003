String mensaje = "";
Connection cn = null;
try {
  // Inicia la Tx
  cn = AccesoDB.getConnection();
  cn.setAutoCommit(false);
  //
  
  // Confirma la Tx
  cn.commit();
  mensaje = "Transacción ok.";
} catch (Exception e) {
  try {
	cn.rollback();
  } catch (Exception e1) {
  }
  mensaje = "Error en el proceso. " + e.getMessage();
} finally{
  try {
	cn.rollback();
  } catch (Exception e) {
  }
}