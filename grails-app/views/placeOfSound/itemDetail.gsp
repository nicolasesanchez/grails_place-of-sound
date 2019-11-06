<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
  <link rel="stylesheet" type="text/css" href="cargarInstrumento.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>

<form>
	<div class="row">
		<div class="col">
  			<img src="..." alt="..." class="img-thumbnail">
		</div>
		<div class="col">
			<div class="input-group mb-3">
  				<div class="input-group-prepend">
    				<span class="input-group-text">Precio</span>
    				<span class="input-group-text">$</span>
  				</div>
  				<input class="form-control" type="number" id="precio" placeholder="Precio producto" readonly>
			</div>		
		</div>		
	</div>	

  	<div class="form-group row">
    	<label for="tituloProd" class="col-sm-2 col-form-label">Titulo</label>
    	<div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="tituloProd" value="titulo publicacion">
    	</div>
  	</div>

  
  	<div class="form-group row">
    	<label for="tipoInstrumento" class="col-sm-2 col-form-label">Tipo Instrumento:</label>
    	<div class="col-sm-10">
      	<input type="text" readonly class="form-control-plaintext" id="tipoInstrumento" value="Tipo de Instrumento">
    	</div>
  	</div>

  	<div class="form-group row">
    	<label for="subtipoInstrumento" class="col-sm-2 col-form-label">Subtipo Instrumento:</label>
    	<div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="subtipoInstrumento" value="Subtipo de Instrumento">
    	</div>
  	</div>

  
  	<p></p>


  	<div class="form-group">
    	<label for="descripcion">Descripcion...</label>
  	</div>

  	

  
  	<button type="comprar" class="btn btn-primary" id="btn">COMPRAR!</button>
</form>