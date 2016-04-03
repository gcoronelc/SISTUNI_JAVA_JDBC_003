package pe.egcc.eurekaappcs.dao.espec;

import java.util.List;

/**
 *
 * @author Gustavo Coronel
 */
public interface CrudDaoEspec<T> {

  T getForId(String id);

  List<T> getForAll();

  List<T> getForCriteria(T bean);

  void insert(T bean);

  void update(T bean);

  void delete(String id);

}
