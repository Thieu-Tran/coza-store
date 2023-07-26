const baseURL = "http://localhost:8080"
let token = localStorage.getItem("token")

let cartArr = []

let dataJson = localStorage.getItem("product-list")
if (dataJson != null) {
    cartArr = JSON.parse(dataJson)
}

$(document).ready(function () {

    let renderCart = () => {
        let cartItem = ''

        cartArr.map((item) => {
            cartItem += `
            <tr class="table_row">
                <td class="column-1">
                    <div class="how-itemcart1">
                        <img src="images/${item.image}" alt="IMG">
                    </div>
                </td>
                <td class="column-2">${item.name}</td>
                <td class="column-3">$ ${item.price}</td>
                <td class="column-4">
                    <div class="wrap-num-product flex-w m-l-auto m-r-0">
                        <div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m" onclick="countDown(${item.id})">
                            <i class="fs-16 zmdi zmdi-minus"></i>
                        </div>
                        <input class="mtext-104 cl3 txt-center num-product" type="number" name="num-product1" value="${item.quantity}">
                        <div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m" onclick="countUp(${item.id})">
                            <i class="fs-16 zmdi zmdi-plus"></i>
                        </div>
                    </div>
                </td>
                <td class="column-5">$ ${(item.price * item.quantity).toFixed(2)}</td>
            </tr>
            `
        })

        let cartList = `
        <tr class="table_head">
            <th class="column-1">Product</th>
            <th class="column-2"></th>
            <th class="column-3">Price</th>
            <th class="column-4">Quantity</th>
            <th class="column-5">Total</th>
        </tr>
        ${cartItem}`

        document.getElementById("cart-list").innerHTML = cartList


        // productCheckout ------------------------------------------------------------------------------
        let priceTotal = 0
        cartArr.map((item) => {
            return priceTotal += item.quantity * item.price
        })

        let checkoutContent = `
        <h4 class="mtext-109 cl2 p-b-30 text-center">
            Cart Totals
        </h4>
        <div class="flex-w flex-t bor12 p-b-13">
            <div class="size-208">
                <span class="stext-110 cl2">
                    Subtotal:
                </span>
            </div>
            <div class="size-209">
                <span class="mtext-110 cl2" value='${priceTotal.toFixed(2)}'>
                    $ ${priceTotal.toFixed(2)}
                </span>
            </div>
        </div>
        <div class="flex-w flex-t bor12 p-t-15 p-b-30">
            <div class="size-208 w-full-ssm">
                <span class="stext-110 cl2">
                    Shipping:
                </span>
            </div>
            <div class="size-209 p-r-18 p-r-0-sm w-full-ssm">
                <p class="stext-111 cl6 p-t-2">
                    There are no shipping methods available. Please double check your address, or
                    contact us if you need any help.
                </p>
                <div class="p-t-15">
                    <span class="stext-112 cl8">
                        Calculate Shipping
                    </span>
                    <div class="rs1-select2 rs2-select2 bor8 bg0 m-b-12 m-t-9">
                        <select class="js-select2 w-100" name="time" id="product-country" onchange="getCountryById()">
                            ${getAllCountry()}
                        </select>
                        <div class="dropDownSelect2"></div>
                    </div>
                    <div class="bor8 bg0 m-b-12">
                        <input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="state"
                            placeholder="State /  country">
                    </div>
                    <div class="bor8 bg0 m-b-22">
                        <input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="postcode"
                            placeholder="Postcode / Zip">
                    </div>
                </div>
            </div>
        </div>
		<div id="price-ship" class="d-flex"></div>`

        document.getElementById("procduct-checkout").innerHTML = checkoutContent

        // reRender bill
        billTotal(priceTotal, 0)
        // Render notify
        document.getElementById("product-notify").setAttribute('data-notify', cartArr.length)

        // getCountryById()
        // productCheckout ------------------------------------------------------------------------------
    }
    window.onload = renderCart

    // getAllCountry ------------------------------------------------------------------------------------
    let getAllCountry = () => {
        $.ajax({
            url: baseURL + "/country",
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {
            let data = result.data
            let countryContent = `<option value="-1">Select a country...</option>`

            data.map((item) => {
                countryContent += `<option value="${item.id}">${item.name}</option>`
            })
            document.getElementById("product-country").innerHTML = countryContent
        })
    }
    window.getAllCountry = getAllCountry
    // getAllCountry ------------------------------------------------------------------------------------

    // getCountryById ------------------------------------------------------------------------------------
    let getCountryById = () => {
        let dataJson = localStorage.getItem("product-list")
        if (dataJson != null) {
            cartArr = JSON.parse(dataJson)
        }
        let priceTotal = 0
        cartArr.map((item) => {
            return priceTotal += item.quantity * item.price
        })

        let id = document.getElementById("product-country").value

        let price = 0;
        let priceShipContent = `
            <div class="size-208">
                <span class="stext-110 cl2">
                    Price ship:
                </span>
            </div>
            <div class="size-209">
                <span class="mtext-110 cl2" value='${price}'>$ ${price}</span>
            </div> `
        document.getElementById("price-ship").innerHTML = priceShipContent

        if (id !== -1 || id != null || id != undefined) {
            $.ajax({
                url: baseURL + "/country/" + id,
                method: "get",
                headers: {
                    Authorization: "Bearer " + token,
                }
            }).done(function (result) {
                price = result.data.price
                priceShipContent = `
                <div class="size-208">
                    <span class="stext-110 cl2">
                        Price ship:
                    </span>
                </div>
                <div class="size-209">
                    <span class="mtext-110 cl2" value='${price}' id='price-ship-value'>$ ${price}</span>
                </div>`
                document.getElementById("price-ship").innerHTML = priceShipContent

                // BILL TOTAL ------------------------------------------------------------------------------------
                billTotal(priceTotal, price)
                // BILL TOTAL ------------------------------------------------------------------------------------
            })
        }
    }
    window.getCountryById = getCountryById
    // getCountryById ------------------------------------------------------------------------------------


    // BILL TOTAL ------------------------------------------------------------------------------------
    let billTotal = (priceProduct, priceShip) => {
        billTotalContent = `
        <div class="flex-w flex-t p-t-27 p-b-33">
            <div class="size-208">
                <span class="mtext-101 cl2">
                    Total:
                </span>
            </div>
            <div class="size-209 p-t-1">
                <span class="mtext-110 cl2">
                    $ ${(priceProduct + priceShip).toFixed(2)}
                </span>
            </div>
        </div>
        <button class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
            Proceed to Checkout
        </button>
        `
        document.getElementById("bill-total").innerHTML = billTotalContent
    }
    // BILL TOTAL ------------------------------------------------------------------------------------


    // Side bar ----------------------------------------------------------------------------------------
    let sideBar = () => {
        let priceTotal = 0
        let sideBarItem = ''
        cartArr.map((item) => {
            priceTotal += item.quantity * item.price
            sideBarItem += `
            <li class="header-cart-item flex-w flex-t m-b-12">
                <div class="header-cart-item-img">
                    <img src="images/${item.image}" alt="IMG" style="height:70px;object-fit:cover">
                </div>
                <div class="header-cart-item-txt p-t-8">
                    <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                        ${item.name.length < 25 ? item.name : item.name.slice(0, 25) + '...'}
                    </a>
                    <span class="header-cart-item-info">
                        ${item.quantity} x $${item.price}
                    </span>
                </div>
            </li>
            `
        })

        let sideBarContent = `
        <ul class="header-cart-wrapitem w-full">
            ${sideBarItem}
        </ul>
        <div class="w-full">
            <div class="header-cart-total w-full p-tb-40">
                Total:  $ ${priceTotal.toFixed(2)}
            </div>
            <div class="header-cart-buttons flex-w w-full">
                <a href="shoping-cart.html"
                    class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
                    View Cart
                </a>
                <a href="shoping-cart.html"
                    class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-b-10">
                    Check Out
                </a>
            </div>
        </div>
        `
        document.getElementById("side-bar").innerHTML = sideBarContent
    }
    window.sideBar = sideBar
    // Side bar ----------------------------------------------------------------------------------------


    let countDown = (id) => {
        let index = cartArr.findIndex((item) => {
            return item.id == id
        })

        let item = cartArr[index]
        item.quantity -= 1
        if (item.quantity <= 0) {
            cartArr.splice(index, 1)
        }
        localStorage.setItem("product-list", JSON.stringify(cartArr))
        renderCart()
    }
    window.countDown = countDown

    let countUp = (id) => {
        let index = cartArr.findIndex((item) => {
            return item.id == id
        })

        let item = cartArr[index]
        item.quantity += 1
        localStorage.setItem("product-list", JSON.stringify(cartArr))
        renderCart()
    }
    window.countUp = countUp



})