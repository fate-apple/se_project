//Sliding Effect Control
head.js("../../skin-select/jquery.cookie.js");
head.js("../../skin-select/skin-select.js");


//-------------------------------------------------------------

//SEARCH MENU
head.js("../../search/jquery.quicksearch.js", function() {

    $('input.id_search').quicksearch('#menu-showhide li, .menu-left-nest li');
   
   

});


//------------------------------------------------------------- 
//PAGE LOADER
head.js("../../pace/pace.js", function() {

    paceOptions = {
        ajax: false, // disabled
        document: false, // disabled
        eventLag: false, // disabled
        elements: {
            selectors: ['.my-page']
        }
    };

});






