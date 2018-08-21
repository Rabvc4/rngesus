$(function(){
    var current = location.pathname;
    if (window.console) console.log('foo');
    $('#nav a.nav-link').each(function(){
        var $this = $(this);
        // if the current path is like this link, make it active
        if($this.attr('href').indexOf(current) !== -1){
            $this.addClass('active');
        }
    })
})

