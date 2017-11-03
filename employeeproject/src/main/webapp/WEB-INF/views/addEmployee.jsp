<!-- Add Employee Page Content -->
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1>Add Employee</h1>
				<p>Please enter employee details</p>
				
				<form action="results" method="POST" class="form-horizontal">
					<fieldset>
						<div class="form-group" id="formcustom">
							<label class="control-label" for="focusedInput">Employee
								Name</label> <input class="form=control" id="focusedInput" type="text"
								name="empName" placeholder="FirstName LastName">

						</div>
						<div class="form-group" id="formcustom">
							<label class="control-label" for="focusedInput">Employee
								Grade</label> <input class="form=control" id="focusedInput" type="text"
								name="empGrade" placeholder="Grade 1-24">

						</div>
						<div class="form-group" id="formcustom">
							<label class="control-label" for="focusedInput">Employee
								Salary</label> <input class="form=control" id="focusedInput" type="text"
								name="empSalary" placeholder="50000">

						</div>
						<div class="form-group">
							<div class="col-lg-10">
								<button type="submit" class="btn btn-primary">Submit</button>
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
