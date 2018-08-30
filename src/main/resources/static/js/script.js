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

$(function(){
    $('.table .item').click(function(event){
        event.preventDefault();
        var href = $(this).attr('href');

        $('.itemForm #description').text("Success");

        $.get(href, function(item, status){
            $('.itemForm #name').text(item.name);
            $('.itemForm #description').text(item.description);
            $('.itemForm #cost').text(item.cost);
            $('.itemForm #weight').text(item.weight);
        });

        $('.itemForm #itemModal').modal();
    });
});