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
            $('.itemForm #name').text(item.name);
            $('.itemForm #description').text(item.description);
            $('.itemForm #weight').text(item.weight + ' lb.');
            $('.itemForm #cost').text(item.value);
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


        $.get(href, function(item, status){
            $('#tradeTable > tbody')
                .append($('<tr>')
                    .attr('class', 'item ' + item.rarity.toLowerCase())
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