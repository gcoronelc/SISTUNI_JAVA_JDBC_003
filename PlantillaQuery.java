Connection cn = null;
try {
  cn = AccesoDB.getConnection();
  
} catch (Exception e) {
  e.printStackTrace();
} finally{
  try {
	cn.close();
  } catch (Exception e) {
  }
}