<!-- Page Content -->
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1>List of All Employees</h1>
				<p>
					Make sure to keep all page content within the
					<code>#page-content-wrapper</code>
					.
				</p>

			</div>
		</div>


		<!-- TEST ROW -->
		<div class="row">
			<div class="col-lg-6">
				<div class="bs-component">
					<table class="table table-striped table-hover ">
						<thead>
							<tr>
								<th>Employee ID</th>
								<th>Name</th>
								<th>Grade</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${employees}" var="employee">
								<tr>
									<td>${employee.id}</td>
									<td>${employee.name}</td>
									<td>${employee.grade}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
			</div>
		</div>

	</div>
</div>