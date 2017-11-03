<!-- Find Page Content -->
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1>Find Employee</h1>
				<p>Please enter employee name</p>
				<p>Filling out form</p>
				<form action="getEmployees" method="POST" class="form-horizontal">
					<fieldset>
						<div class="form-group" id="formcustom">
							<label class="control-label" for="focusedInput">Employee
								Name</label> <input class="form=control" id="focusedInput" type="text"
								name="empName" placeholder="FirstName LastName">

						</div>
						<div class="form-group">
							<div class="col-lg-10">
								<button type="submit" class="btn btn-primary">Search by
									Employee Name</button>
							</div>
						</div>
					</fieldset>
				</form>

				<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle
					Menu</a>
			</div>
		</div>
	</div>
</div>
