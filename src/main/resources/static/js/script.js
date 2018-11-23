//$(function(){
//    var current = location.pathname;
//    $('#nav a.nav-link').each(function(){
//        var $this = $(this);
//        // if the current path is like this link, make it active
//        if($this.attr('href').indexOf(current) !== -1){
//            $this.addClass('active');
//        }
//    })
//})

//$(function(){
//
//    $('.table .item').on('click',function(event){
//        event.preventDefault();
//        if (window.console) console.log('foo');
//
//        $('.myForm #itemModal').modal();
//    });
//});


//------------------------Active Scripts Below

//$(function(){
//    $('.table .item').click(function(event){
//        event.preventDefault();
//        var href = $(this).attr('href');
//
//        $.get(href, function(item, status){
//            $('.itemForm #name').text(item.name);
//            $('.itemForm #description').text(item.description);
//            $('.itemForm #weight').text(item.weight + ' lb.');
//            $('.itemForm #cost').text(item.value);
//            $("#addToCart").attr('href', '/inventory/addToCart/?id=' + item.id)
//        });
//
////        $('.itemForm #itemModal').modal({backdrop: false});
//        $('.itemForm #itemModal').modal();
//    });
//});

$(function(){
    $('.table .item').click(function(event){
        event.preventDefault();
        var href = '/item/details/?id=' + $(this).attr('id');

        $.get(href, function(item, status){
            $('.itemForm #header')
                .attr('class', 'modal-header modal-dark ' + item.rarity.toLowerCase())
            $('.itemForm #name').text(item.name);
            var details = item.rarity;
            details += ' ' + item.type;
            details = details.replace(/\_/g, ' ').toLowerCase();
            $('.itemForm #itemDetails')
                .text(details)
                .addClass('text-capitalize')
            $('.itemForm #description').text(item.description);
            $('.itemForm #weight').text(item.weight + ' lb.');
            $('.itemForm #cost').text('$' + item.value);
            $("#addToCart").val(item.id)
        });

//        $('.itemForm #itemModal').modal({backdrop: false});
        $('.itemForm #itemModal').modal();
    });
});

$(function(){
    $('#addToCart').click(function(event){
        event.preventDefault();
        var href = '/item/details/?id=' + $(this).val();
//        var total = +($('#total').find('.number').text());
//        var weight = +($('#tradeWeight').find('.number').text());
        var total = +($('#total').text());
        var weight = +($('#tradeWeight').text());

        $.get(href, function(item, status){
            $('#total').text(total + item.value)
            $('#tradeWeight').text(weight + item.weight)
            $('#tradeTable > tbody')
                .append($('<tr>')
                    .attr('class', 'buy border-warning item ' + item.rarity.toLowerCase())
                    .append($('<td>')
                        .text(item.name)
                )
                    .append($('<td>')
                        .text(item.weight + ' lb.')
                )
                    .append($('<td>')
                        .text('$' + item.value)
                )
            );
        });
    });
});

//$(function(){
//    $('#baseClass').on('change', function() {
//        event.preventDefault();
//        var href = '/class/details/?id=' + $(this).val();
//
//        $.get(href, function(characterClass, status){
//            alert( characterClass.name )
//        });
//    });
//});