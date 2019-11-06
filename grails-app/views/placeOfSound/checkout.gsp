<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>


<form>
  	<div class="form-group row">
    	<label for="vendedor" class="col-sm-2 col-form-label">Nombre Vendedor</label>
    	<div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="vendedor" value="Juan Gomez">
    	</div>

  	</div>
	
	<div class="input-group mb-3">
  		<div class="input-group-prepend">
    		<span class="input-group-text">Precio</span>
    		<span class="input-group-text">$</span>
  		</div>
  		<input class="form-control" type="number" id="precio" placeholder="Precio producto" readonly>
	</div>

	
  	<div class="form-group row">
    	<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
    	<div class="col-sm-10">
      		<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="email@example.com">
    	</div>
  	</div>
  
</form>