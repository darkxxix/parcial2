<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Adicionar Vehículo</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="todo">
						<form:hidden path="id" />
						
						<fieldset class="form-group">
							<form:label path="placa">Placa</form:label>
							<form:input path="placa" type="text" class="form-control"
								required="required" />
							<form:errors path="placa" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="horaEntrada">Hora de Entrada</form:label>
							<form:input path="horaEntrada" type="text" class="form-control"
								required="required" />
							<form:errors path="horaEntrada" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="horaSalida">Hora de Salida</form:label>
							<form:input path="horaSalida" type="text" class="form-control"
								required="required" />
							<form:errors path="horaSalida" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="ubicacion">Ubicación</form:label>
							<form:input path="ubicacion" type="text" class="form-control"
								required="required" />
							<form:errors path="ubicacion" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="tipo">Tipo</form:label>
							<form:input path="tipo" type="text" class="form-control"
								required="required" />
							<form:errors path="tipo" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Guardar</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jsp"%>