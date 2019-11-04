<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" href="cargarInstrumento.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>

<g:uploadForm method="POST" url="/submit_instrument">
    <div class="form-group">
        <label for="tituloProd">Titulo Producto</label>
        <input type="text" name="title" class="form-control" id="tituloProd" placeholder="Ingrese un titulo a publicar" required/>
%{--        <input type="text"  value="" required="" id="game" />--}%
    </div>

    <div class="form-row align-items-center" id="productRow0">
        <div class="col-auto my-1">
            <label for="tipoInstrumento">Tipo Instrumento</label>
            %{--<select class="custom-select" id="product" required>
                <option value="default">Elegir tipo Instrumento</option>
                <g:each var="category" in="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </g:each>
            </select>--}%

            <g:select class="custom-select" name="category" from="${categories}" optionKey="id" optionValue="name"
                      noSelection="[null: ' ']"/>

        </div>
    </div>

    <br>

    <div class="form-group">
        <label for="descripcion">Descripcion:</label>
        <textarea name="description" class="form-control" id="descripcion" placeholder="Describir el producto"></textarea>
    </div>

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">Precio</span>
            <span class="input-group-text">$</span>
        </div>
        <input class="form-control" name="price" type="number" id="precio" placeholder="Ingrese precio producto" required/>
    </div>

%{--    <img src="${image}" alt="Grails" />--}%
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">Upload</span>
        </div>

        <div class="custom-file">
            <input type="file" name="picture" class="custom-file-input" id="inputGroupFile01">
            <label class="custom-file-label" for="inputGroupFile01">Cargar foto del producto</label>
        </div>
    </div>

    <button type="submit" class="btn btn-primary" id="btn">Publicar!</button>
</g:uploadForm>



%{--TODO cambiar el js porque esto era para node--}%
%{--
<script type="text/javascript">
    var products = <%- JSON.stringify(products) %>;
    var selectedObj;
    var count = 0;
    $("#newProduct").click(function () {
        var template = '<div class="form-row align-items-center" id="productRow' + ++count + '">\n' +
            '    <div class="col-auto my-1">\n' +
            '      <label for="producto">Producto</label>\n' +
            '      <select class="custom-select" id="products' + count + '">\n' +
            '        <option value="default">Elegir Producto</option>\n' +
            '        <% products.forEach((product) => { %>\n' +
            '        <option value=<%= product.id %>><%= product.name %></option>\n' +
            '        <% }) %>\n' +
            '      </select>\n' +
            '    </div>\n' +
            '    <div class="col-auto my-1" id="price' + count + '">\n' +
            '      <label for="precioproducto">Precio unidad</label>\n' +
            '      <input class="form-control" type="text" disabled="disabled">\n' +
            '    </div>\n' +
            '    <div class="col-auto my-1">\n' +
            '      <label for="cantidadproducto">Cantidad Producto</label>\n' +
            '      <input type="text" class="form-control" id="qty' + count + '" placeholder="Ingrese Cantidad">\n' +
            '    </div>\n' +
            '    <div class="col" id="total' + count + '">\n' +
            '      <label for="totalproducto">Precio Producto</label>\n' +
            '      <input type="text" class="form-control" id="totalProduct' + count + '" placeholder="Total Producto" disabled="disabled">\n' +
            '    </div>';
        $(".form-row").last().after(template);
        reloadChangeEvents();
    });

    function reloadChangeEvents() {
        // retrieves all the input rows and adds listeners on change to set the each of its price
        for (var i = 0; i < (count + 1); i++) {
            var product = ("#products" + i);
            var index;
            $(product).change(function () {
                index = i - 1;
                var selected = $((product + " option:selected"));
                selectedObj = products.find(function (p) {
                    return p.id == selected.val();
                });
                $(("#price" + index + " input")).val(selectedObj.price);
            });
            $(("#qty" + i)).keyup(function () {
                var qty = Number($(this).val());
                $(("#total" + index + " input")).val((qty * selectedObj.price));
            });
        }
    }

    reloadChangeEvents();
    $("#finish").click(function () {
        var total = 0;
        for (var i = 0; i < (count + 1); i++) {
            total += Number($(("#totalProduct" + i)).val());
        }
        $("#totalOrder").val(total);
    });
</script>--}%
