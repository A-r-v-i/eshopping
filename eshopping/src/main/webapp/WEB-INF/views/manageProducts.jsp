<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row">

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body">

					<!-- Form elements -->

					<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products"
					method="POST" >
						<div class="form-group">
							<lable class="control-label col-md-4" for="name">Enter
							Product name:</lable>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name"
									class="form-control" /> <em class="help-block">Please
									enter product name</em>

							</div>

						</div>

						<div class="form-group">
							<lable class="control-label col-md-4" for="brand">Enter
							Brand name:</lable>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control" /> <em class="help-block">Please
									enter brand name</em>

							</div>

						</div>
						<div class="form-group">
							<labe class="control-label col-md-4" for="description">Enter
							description here!</labe>
							<div class="col-md-8">
								<sf:textarea path="description" rows="6"
									placeholder="Write your product description here!" />
							</div>
						</div>

						<div class="form-group">
							<labe class="control-label col-md-4" for="unitPrice">Enter
							unit price</labe>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Price of product in &#8377;" />
							</div>
						</div>

						<div class="form-group">
							<labe class="control-label col-md-4" for="quantity">Quantity
							available</labe>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity of products" />
							</div>
						</div>

						<div class="form-group">
							<labe class="control-label col-md-4" for="categoryId">Select
							category</labe>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId" 
								items="${categories}"
								itemLabel="name"
								itemValu="id"
								/>
								
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" value="Submit"
									class="btn btn-primary" />
									
									<sf:hidden path="id" />
	                                <sf:hidden path="code" />
	                                <sf:hidden path="supplierId" />
	                                <sf:hidden path="active" />
	                                <sf:hidden path="purchase" />
	                                <sf:hidden path="views" />								
							</div>
						</div>
				</div>



			</div>

		</div>



		</sf:form>

	</div>

</div>

</div>

</div>

</div>