<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Actualizar</title>
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <%
String id = request.getParameter("id");
String nombre = request.getParameter("nombre");
String apellido = request.getParameter("apellido");


if(id ==null){
	
	id ="";
	nombre="";
	apellido="";
}

%>
  </head>
  <body>
  <form action="ServeleteUser">
   
    <section>
      <div id="datos" class="text-center">
        <div class="container">
          <div class="row">
            <div class="col">
           
            <div class="input-group mb-3">
            <label for="id1" class="col-sm-2 col-form-label">ID</label>
            <div class="col-sm-10">
    <input type="text" class="form-control" name="Id" placeholder="Id" value="<%=id%>">
    </div>
  </div>
              <div class="input-group mb-3">
             <label for="nombre1" class="col-sm-2 col-form-label">Nombre</label>
               <div class="col-sm-10">
    <input type="text" class="form-control" name="nombre"  placeholder="Nombre" value="<%=nombre%>">
    </div>
  </div>
  <div class="input-group mb-3">
  <label for="edad1" class="col-sm-2 col-form-label">Apellido</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" name="apellido" placeholder="Apellido" value="<%=apellido%>">
    </div>
  </div>
              </div>
          </div>
          
          <input type="submit" class="btn btn-info" value="Actualizar" name="btn">
  
        </div>
      </div>
    </section>
    
      </form>
  </body>
</html>
        