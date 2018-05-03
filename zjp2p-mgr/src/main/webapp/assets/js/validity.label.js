(function($) {
	function getIdentifier($obj) {
        return $obj.attr('id').length ?
            $obj.attr('id') :
            $obj.attr('name');
    }
	$.validity.outputs.label = {
	        cssClass:"error",
	    
	        start:function() {
	            // Remove all the existing error labels.
//		            $("label.error[for]").hide();
//		                .removeClass($.validity.outputs.label.cssClass);
	        },
	        
	        end:function(results) {
	            // If not valid and scrollTo is enabled, scroll the page to the first error.
	            if (!results.valid && $.validity.settings.scrollTo) {
					location.hash = $("." + $.validity.outputs.label.cssClass + ":eq(0)").attr('for');
				}
	        },

	        raise:function($obj, msg) {
	            var 
	                labelSelector = "label"+ "[for='" + getIdentifier($obj) + "']";

	            // If an error label already exists for the bad input just update its text:
	            if ($(labelSelector).length) {
	                $(labelSelector).removeClass().addClass($.validity.outputs.label.cssClass).text(msg).show();
	            }
	        },

	        raiseAggregate:function($obj, msg) {
	            // Just raise the error on the last input.
	            alert(getIdentifier($obj).length);
	            if ($obj.length) {
	                this.raise($($obj.get($obj.length - 1)), msg);
	            }
	        }
	    };
})(jQuery);