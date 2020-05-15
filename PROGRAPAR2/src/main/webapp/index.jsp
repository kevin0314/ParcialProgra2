<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <script src="http://code.jquery.com/jquery-latest.js"></script>
      <script type="text/javascript">
$(document).ready(function(){
	  $('#Cargar').click(function(event){
		  var btn =$('#Cargar').val();
		  $.post('ServeletController',{
			}, function(response){
				let datos = JSON.parse(response);
				console.log(response);
			  var tablac = document.getElementById('tablaconsulta') 
				for(let item of datos){

					tablac.innerHTML += `
					<tr>
					<td>${item.apellido}</td>	
					<td>${item.nombre}</td>	
					<td>${item.id}</td>
					
			<td>
					<form action="ServeleteUser">
					  
					<div class="btn-group" role="group" aria-label="Basic example">
					<a href="Actualizar.jsp?id=${item.id}&nombre=${item.nombre}&apellido=${item.apellido}" class="btn btn-danger">ACTUALIZAR</a>
					<a href="ServeleteUser?btn=Eliminar&Id=${item.id}" class="btn btn-warning">ELIMINAR</a> 
					</form>
					 </div> 
			</td>
					
		</tr>
		`
				}
	  });
	 
	});
});		
</script>

  </head>
  <body>
    <div class="btn-group" role="group" aria-label="Basic example">
    <a href="login.jsp" class="btn btn-warning">Iniciar sesion</a>
<button type="button" class="btn btn-info" id="Cargar">Cargar Datos</button>
</div>
<table class="table table-striped table-dark" id="tablaconsulta">
  <thead>
    <tr>
      <th scope="col">Apellido</th>
      <th scope="col">Nombre</th>
       <th scope="col">ID</th>
      <th scope="col">Opciones</th>
    </tr>
  </thead>
  <tbody>

  </tbody>
</table>
  </body>
</html>