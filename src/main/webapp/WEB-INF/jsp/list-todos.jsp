<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-todo">Adicionar Vehiculo</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Lista de Vehiculos</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="10%">Placa</th>
						<th width="10%">Entrada(hr)</th>
						<th width="10%">Salida(hr)</th>
					    <th width="10%">Ubicación</th>
					    <th width="15%">Tipo</th>
						<th width="30%">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
						
							<td>${todo.placa()}</td>
							<td>${todo.id()}</td>
							<td><fmt:formatDate value="${todo.horaEntrada}"
									pattern="HH:mm:ss" /></td>
							<td><fmt:formatDate value="${todo.horaSalida}"
									pattern="HH:mm:ss" /></td>
							<td>${todo.ubicacion()}</td>
							<td>${todo.tipo()}</td>
							
							<td>
							<a type="button" class="btn btn-success"
								href="/update-todo?id=${todo.id}">Actualizar</a>
							<a type="button" class="btn btn-warning"
								href="/delete-todo?id=${todo.id}">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jsp"%>