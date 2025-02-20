<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Webapp demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-primary navbar-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand mx-auto" href="#">Web App demo</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
				aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end" tabindex="-1"
				id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
					<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
						aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">News</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Popular </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Internantionl</a></li>
								<li><a class="dropdown-item" href="#">Technology</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="#">All Categories</a></li>
							</ul></li>
					</ul>
					<form class="d-flex mt-3" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</div>
	</nav>
	<main>
		<div class="container py-5">
			<div class="col-md-4 mx-auto py-5">
				<form method="post" action="signin">
					<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

					<div class="form-floating">
						<input type="email" class="form-control" id="floatingInput"
							name="email" placeholder="name@example.com"> <label
							for="floatingInput">Email address</label>
					</div>
					<div class="form-floating">
						<input type="password" class="form-control" id="floatingPassword"
							name="password" placeholder="Password"> <label
							for="floatingPassword">Password</label>
					</div>

					<div class="form-check text-start my-3">
						<input class="form-check-input" type="checkbox"
							value="remember-me" id="flexCheckDefault"> <label
							class="form-check-label" for="flexCheckDefault"> Remember
							me </label>
					</div>
					<button class="btn btn-primary w-100 py-2" type="submit">Sign
						in</button>
				</form>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>