<!-- Display found employees -->
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="row">
				<div class="col-lg-10">
					<div class="bs-component">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>Employee ID</th>
									<th>Name</th>
									<th>Grade</th>
									<th>Salary</th>
									<th>Is Active</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employees}" var="employee">
									<tr>
										<td>${employee.empId}</td>
										<td>${employee.name}</td>
										<td>${employee.grade}</td>
										<td>${employee.salary}</td>
										<td>${employee.isActive}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


