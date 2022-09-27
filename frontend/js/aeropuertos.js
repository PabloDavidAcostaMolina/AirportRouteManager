function loadData(){
    let request = sendRequest('airport/list' , 'GET' , '')
    let table = document.getElementById('airport-table');
    table.innerHTML = "";
    request.onload = function(){

        let data = request.response;
        console.log(data);
        data.forEach((element,index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.idAirport}</th>
                    <td>${element.airport}
                    <td>${element.city.idCity}
                    <td>
                       <button type="button" class="btn btn-primary"
                       onclick='window.location = "form_aeropuertos.html?id=${element.idAirport}"'>Editar</button>
                       <button type = "button" class = "btn btn-danger"
                       onclick='deleteAirport(${element.idAirport})'>Eliminar</button>
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

function loadAirport(idAirport){
    let request = sendRequest('airport/list/'+idAirport, 'GET', '')
    let airport = document.getElementById('airport-name')
    let idCity = document.getElementById('city-id')
    let id = document.getElementById('airport-id')
    request.onload = function(){
        
        let data = request.response
        id.value = data.idAirport
        airport.value = data.airport 
        idCity.value = data.city.idCity

        
        
        
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteAirport(idAirport){
    let request = sendRequest('airport/'+idAirport, 'DELETE','')
    request.onload = function(){
        loadData()
    }

}

function saveAirport(){
    let airport = document.getElementById('airport-name').value
    let city = document.getElementById('city-id').value
    let id = document.getElementById('airport-name').value
    let data = {'idAirport':id,'airport':airport, 'city':city.idCity}
    let request = sendRequest('airport/',id ? 'PUT' : 'POST',data)
    request.onload = function(){
        window.location = 'aeropuertos.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios')
    }

}