const baseURL = "http://localhost:8080"
let token = localStorage.getItem("token")

let queryString = window.location.search
let id = new URLSearchParams(queryString).get("id")
let categoryId = new URLSearchParams(queryString).get("category_id")

$(document).ready(function () {

    // getProductById ---------------------------------------------------------------------------------
    $.ajax({
        url: baseURL + "/product/" + id,
        method: "get",
        headers: {
            Authorization: "Bearer " + token,
        }
    }).done(function (result) {

        let data = result.data
        // tách chuỗi image thành mảng đối tượng
        let imageDetailArr = data.imageDetail.split(",")
        let imageDetail = ''
        let imageInformation = `
                <h4 class="mtext-105 cl2 js-name-detail p-b-14">
					${data.name}
				</h4>
				<span class="mtext-106 cl2">
					$${data.price}
				</span>
				<p class="stext-102 cl3 p-t-23">
					${data.description}
				</p>`

        imageDetailArr.map((element) => {
            imageDetail += `
                <div class="item-slick3" data-thumb="images/${element}">
                    <div class="wrap-pic-w pos-relative">
                        <img src="images/${element}" alt="IMG-PRODUCT" style="height: 70vh;object-fit:cover">
                        <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="images/${element}">
                            <i class="fa fa-expand"></i>
                        </a>
                    </div>
                </div>`
            return imageDetail
        })

        let slickContent = `
                <div class="wrap-slick3 flex-sb flex-w">
                    <div class="wrap-slick3-dots"></div>
                    <div class="wrap-slick3-arrows flex-sb-m flex-w"></div>
                    <div class="slick3 gallery-lb" id="image-detail">
                        ${imageDetail}
                    </div>
                </div>`

        document.getElementById("slick-content").innerHTML = slickContent
        document.getElementById("product-information").innerHTML = imageInformation

        $('.wrap-slick3').each(function () {
            $(this).find('.slick3').slick({
                slidesToShow: 1,
                slidesToScroll: 1,
                fade: true,
                infinite: true,
                autoplay: true,
                autoplaySpeed: 3000,

                arrows: true,
                appendArrows: $(this).find('.wrap-slick3-arrows'),
                prevArrow: '<button class="arrow-slick3 prev-slick3"><i class="fa fa-angle-left" aria-hidden="true"></i></button>',
                nextArrow: '<button class="arrow-slick3 next-slick3"><i class="fa fa-angle-right" aria-hidden="true"></i></button>',

                dots: true,
                appendDots: $(this).find('.wrap-slick3-dots'),
                dotsClass: 'slick3-dots',
                customPaging: function (slick, index) {
                    var portrait = $(slick.$slides[index]).data('thumb');
                    return '<img src=" ' + portrait + ' "/><div class="slick3-dot-overlay"></div>';
                },
            });
        });
    })

    let productDetail = (produtID) => {
        $.ajax({
            url: baseURL + "/product/" + produtID,
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {

            let data = result.data
            // tách chuỗi image thành mảng đối tượng
            let imageDetailArr = data.imageDetail.split(",")
            let imageDetail = ''
            let imageInformation = `
                <h4 class="mtext-105 cl2 js-name-detail p-b-14">
					${data.name}
				</h4>
				<span class="mtext-106 cl2">
					$${data.price}
				</span>
				<p class="stext-102 cl3 p-t-23">
					${data.description}
				</p>`

            imageDetailArr.map((element) => {
                imageDetail += `
                <div class="item-slick3" data-thumb="images/${element}">
                    <div class="wrap-pic-w pos-relative">
                        <img src="images/${element}" alt="IMG-PRODUCT" style="height: 70vh;object-fit:cover">
                        <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="images/${element}">
                            <i class="fa fa-expand"></i>
                        </a>
                    </div>
                </div>`
                return imageDetail
            })

            // Thêm class wrap-slick-add để tránh trùng với class có sẵn
            let slickContent = `
                <div class="wrap-slick3 wrap-slick-add flex-sb flex-w">
                    <div class="wrap-slick3-dots"></div>
                    <div class="wrap-slick3-arrows flex-sb-m flex-w"></div>
                    <div class="slick3 gallery-lb" id="image-detail">
                        ${imageDetail}
                    </div>
                </div>`

            document.getElementById("slick-content-2").innerHTML = slickContent
            document.getElementById("product-information-2").innerHTML = imageInformation

            // call class wrap-slick-add
            $('.wrap-slick-add').each(function () {
                $(this).find('.slick3').slick({
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    fade: true,
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 3000,

                    arrows: true,
                    appendArrows: $(this).find('.wrap-slick3-arrows'),
                    prevArrow: '<button class="arrow-slick3 prev-slick3"><i class="fa fa-angle-left" aria-hidden="true"></i></button>',
                    nextArrow: '<button class="arrow-slick3 next-slick3"><i class="fa fa-angle-right" aria-hidden="true"></i></button>',

                    dots: true,
                    appendDots: $(this).find('.wrap-slick3-dots'),
                    dotsClass: 'slick3-dots',
                    customPaging: function (slick, index) {
                        var portrait = $(slick.$slides[index]).data('thumb');
                        return '<img src=" ' + portrait + ' "/><div class="slick3-dot-overlay"></div>';
                    },
                });
            });
        })

    }
    window.productDetail = productDetail

    // getProductById ---------------------------------------------------------------------------------


    // getAllSize -------------------------------------------------------------------------------------
    let getAllSize = (idName) => {
        $.ajax({
            url: baseURL + "/size",
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {
            let data = result.data
            let productSize = `<option>Choose an option</option>`


            for (let index = 0; index < data.length; index++) {
                let item = data[index]

                productSize += `<option>Size ${item.name}</option>`

            }
            document.getElementById(idName).innerHTML = productSize
        })
    }
    window.onload = getAllSize("product-size")
    window.getAllSize = getAllSize("product-size-2")

    // getAllSize -------------------------------------------------------------------------------------



    // getAllColor -------------------------------------------------------------------------------------

    let getAllColor = (idName) => {
        $.ajax({
            url: baseURL + "/color",
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {
            let data = result.data
            let productColor = `<option>Choose an option</option>`

            for (let index = 0; index < data.length; index++) {
                let item = data[index]

                productColor += `<option>${item.name}</option>`

            }
            document.getElementById(idName).innerHTML = productColor
        })
    }
    window.getAllColor = getAllColor("product-color-2")
    window.onload = getAllColor("product-color")


    // getAllColor -------------------------------------------------------------------------------------


    // addToCart ---------------------------------------------------------------------------------------

    let addToCartBtn = `
    <button class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail" onclick="addToCart(${id})">
            Add to cart
    </button>`
    document.getElementById("addToCart").innerHTML = addToCartBtn

    let addToCart = (id) => {
        console.log(id)
    }
    window.addToCart = addToCart

    // addToCart ---------------------------------------------------------------------------------------


    // Load product item ---------------------------------------------------------------------------------

    $.ajax({
        url: baseURL + "/product" + "/category/" + categoryId,
        method: "get",
        headers: {
            Authorization: "Bearer " + token,
        }
    }).done(function (result) {
        let data = result.data
        let productItem = ''

        data.map((item) => {
            productItem += `
            <div class="item-slick2 p-l-15 p-r-15 p-t-15 p-b-15">
						<div class="block2">
							<div class="block2-pic hov-img0">
								<img src="images/${item.image}" alt="IMG-PRODUCT" style="height:390px">
								<a class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1 pointer" onclick="modalProductDetail(${item.id})">
									Quick View
								</a>
							</div>
							<div class="block2-txt flex-w flex-t p-t-14">
								<div class="block2-txt-child1 flex-col-l ">
									<a href="product-detail.html?id=${item.id}&category_id=${categoryId}"
										class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6 text-truncate w-75">
										${item.name}
									</a>
									<span class="stext-105 cl3">
										$${item.price}
									</span>
								</div>
								<div class="block2-txt-child2 flex-r p-t-3">
									<a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2" onclick="handleFavorite()">
										<img class="icon-heart1 dis-block trans-04" src="images/icons/icon-heart-01.png"
											alt="ICON">
										<img class="icon-heart2 dis-block trans-04 ab-t-l"
											src="images/icons/icon-heart-02.png" alt="ICON">
									</a>
								</div>
							</div>
						</div>
					</div>
            `
        })

        let productList = `				
            <div class="wrap-slick2">
                <div class="slick2">
                    ${productItem}
                </div>
            </div>`
        document.getElementById("product-item").innerHTML = productList

        // gọi lại slick vì load data mới không hoạt động
        $('.wrap-slick2').each(function () {
            $(this).find('.slick2').slick({
                slidesToShow: 4,
                slidesToScroll: 4,
                infinite: true,
                autoplay: true,
                autoplaySpeed: 3000,
                arrows: true,
                appendArrows: $(this),
                prevArrow: '<button class="arrow-slick2 prev-slick2"><i class="fa fa-angle-left" aria-hidden="true"></i></button>',
                nextArrow: '<button class="arrow-slick2 next-slick2"><i class="fa fa-angle-right" aria-hidden="true"></i></button>',
                responsive: [
                    {
                        breakpoint: 1200,
                        settings: {
                            slidesToShow: 4,
                            slidesToScroll: 4
                        }
                    },
                    {
                        breakpoint: 992,
                        settings: {
                            slidesToShow: 3,
                            slidesToScroll: 3
                        }
                    },
                    {
                        breakpoint: 768,
                        settings: {
                            slidesToShow: 2,
                            slidesToScroll: 2
                        }
                    },
                    {
                        breakpoint: 576,
                        settings: {
                            slidesToShow: 1,
                            slidesToScroll: 1
                        }
                    }
                ]
            });
        });

        $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
            var nameTab = $(e.target).attr('href');
            $(nameTab).find('.slick2').slick('reinit');
        });


    })

    // Load product item ---------------------------------------------------------------------------------


    // show modal product detail ----------------------------------------------------------------------
    let modalProductDetail = (id) => {
        $('.js-modal1').addClass('show-modal1');

        productDetail(id)
        getAllSize("product-size-2")
        getAllColor("product-color-2")

        let addToCartBtn = `
            <button class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail" onclick="addToCart(${id})">
                    Add to cart
            </button>`

        document.getElementById("addToCart").innerHTML = addToCartBtn
    }
    window.modalProductDetail = modalProductDetail

    // handleFavorite ---------------------------------------------------------------------------------

    let handleFavorite = () => {
        $('.js-addwish-b2').each(function () {
            var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
            $(this).on('click', function () {
                swal(nameProduct, "is added to wishlist !", "success");

                $(this).addClass('js-addedwish-b2');
                $(this).off('click');
            });
        });

        $('.js-addwish-detail').each(function () {
            var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').html();

            $(this).on('click', function () {
                swal(nameProduct, "is added to wishlist !", "success");

                $(this).addClass('js-addedwish-detail');
                $(this).off('click');
            });
        });
    }
    window.handleFavorite = handleFavorite
    // handleFavorite ---------------------------------------------------------------------------------



})