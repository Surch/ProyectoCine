'use strict';

/* Services */

var services = angular.module('homecinema.services', ['hcResource']);

services.factory('UserFactory', function ($resource) {
    return $resource('/homecinema/rest/users', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});
