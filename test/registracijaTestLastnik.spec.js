describe('registracija uporabnika lastnika', function () {
    it('Obisk strani za registracijo in registracija', function () {
        cy.visit('http://localhost:4200/')

        cy.url()
            .should('include', '/')

        cy.get('.btn').contains(' Registracija kot lastnik psov ')
            .click()

        cy.url()
            .should('include', '/signup/lastnik')

        cy.get('.name')
            .type('Lastnik')
            .should('have.value', 'Lastnik')

        cy.get('.lastname')
            .type('Lastničko')
            .should('have.value', 'Lastničko')

        cy.get('.username')
            .type('lastničko')
            .should('have.value', 'lastničko')

        cy.get('.email')
            .type('lastnik@gmail.com')
            .should('have.value', 'lastnik@gmail.com')

        cy.get('.password1')
            .type('lastnik')
            .should('have.value', 'lastnik')

        cy.get('.password2')
            .type('lastnik')
            .should('have.value', 'lastnik')

        cy.get('[type="radio"]').check('lastnik')

        cy.get('.btn-primary')
            .click()
        cy.wait(500)



        cy.get('h1').contains('PRIJAVA')
    });
});
