
$("#linkPromocao").on('change', function() {
	let url = $(this).val();
	
	if (url.length > 7) {
		$.ajax({
			method: "POST",
			url: `/meta/info?url=${url}`,
			cache: false,
			beforeSend: () => {
				$("#alert").removeClass("alert alert-danger").text("");
				$("#titulo").val("");
				$("#site").text("");
				$("#linkImagem").attr("src", "");
				$("#loader-img").addClass("loader");
				
			},
			success: (data) => {
				$("#titulo").val(data.title);
				$("#site").text(data.site.replace("@", ""));
				$("#linkImagem").attr("src", data.image);
			},
			statusCode: {
				404: () => {
					$("#alert").addClass("alert alert-danger").text("Nenhuma informação encontrada na URL informada. Favor verificar.");
					$("#linkImagem").attr("src", "/images/promo-dark.png");
				}
			},
			error: () => {
				$("#alert").addClass("alert alert-danger").text("Opss... Algo inesperado aconteceu, tente novamente mais tarde.");
				$("#linkImagem").attr("src", "/images/promo-dark.png");
			},
			complete: () => {
				$("#loader-img").removeClass("loader");
			}
		})
	}
});



