 private void cargarFormulario(Class<?> aClass) {
    try {
      JInternalFrame view;
      view = buscarFormulario(aClass);
      if(view == null){
        view = (JInternalFrame) Class.forName(aClass.getName()).newInstance();
        desktopPane.add(view);
        view.setVisible(true);
      }
      // Activando el formulario
      view.setSelected(true);
    } catch (Exception e) {
    }
  }

  private JInternalFrame buscarFormulario(Class<?> aClass) {
    JInternalFrame view = null;
    for(JInternalFrame bean: desktopPane.getAllFrames()){
      if(aClass.isInstance(bean)){
        view = bean;
        break;
      }
    }
    return view;
  }