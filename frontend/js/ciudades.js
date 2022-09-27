function loadData(){
    let request = sendRequest('city/list' , 'GET' , '')
    let table = document.getElementById('city-table');
    table.innerHTML = "";
    request.onload = function(){

        let data = request.response;
        console.log(data);
        data.forEach((element,index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.idCity}</th>
                    <td>${element.city}
                    <td>
                       <button type="button" class="btn btn-primary"
                       onclick='window.location = "form_ciudades.html?id=${element.idCity}"'>Editar</button>
                       <button type = "button" class = "btn btn-danger"
                       onclick='deleteCity(${element.idCity})'>Eliminar</button>
                    </td>
                </tr>

                `
                
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="6"> Error al recuperar dato.</td>
            </tr>
        `;
    }
}

function loadCity(idCity){
    let request = sendRequest('city/list/'+idCity, 'GET', '')
    let city = document.getElementById('city-name')
    let id = document.getElementById('city-id')
    request.onload = function(){
        
        let data = request.response
        id.value = data.idCity
        city.value = data.city
        
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteCity(idCity){
    let request = sendRequest('city/'+idCity, 'DELETE','')
    request.onload = function(){
        loadData()
    }

}

function saveCity(){
    let city = document.getElementById('city-name').value
    let id = document.getElementById('city-id').value
    let data = {'idCity':id,'city':city}
    let request = sendRequest('city/',id ? 'PUT' : 'POST',data)
    request.onload = function(){
        window.location = 'ciudades.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios')
    }

}

