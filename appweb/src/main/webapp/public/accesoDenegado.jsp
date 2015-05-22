
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<div class="container content">


<p class="post-title">
	Estimado miembro de la comunidad de DoChef. Esa a punto de convertirse en usuario PREMIUM por 
	sólo $3.00 mensuales y acceder a material exclusivo...
</p>


                            <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
                                <input type='hidden' name='cmd' value='_xclick'>
                                <input type='hidden' name='business' value='jamdiazdiaz@gmail.com'>
                                <input type='hidden' name='item_name' value='DoChef Paypal'>
                                <input type='hidden' name='item_number' value='1'>
                                <input type="hidden" name="quantity" id="CANTIDADPAYPAL" value="1">
                                <input type="hidden" name="discount_amount" id="DESCUENTOPAYPAL" value="0">
                                <input type='hidden' name='amount' id="MONTOPAYPAL"
                                       value='3.0'>
                                <input type='hidden' name='page_style' value='primary'>
                                <input type='hidden' name='no_shipping' value='1'>
                                <input type='hidden' name='return' id="returnpaypal"
                                       value='http://www.dochef.net/paypal/gracias'>
                                <input type='hidden' name='rm' value='2'>
                                <input type='hidden' name='no_note' value='1'>
                                <input type='hidden' name='currency_code' value='USD'>
                                <input type='hidden' name='cn' value='PP-BuyNowBF'>
                                <input type='hidden' name='custom' value=''>
                                <input type='hidden' name='lc' value='es'>
                                <button class="btn btn-default" id="btnPagar" type="submit"><b>Pagar con paypal</b>
                                </button>
                            </form>

</div>