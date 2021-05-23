describe('registracija uporabnika izvajalca', function () {
    it('Obisk strani za registracijo in registracija', function () {
        cy.visit('http://localhost:4200/')

        cy.url()
            .should('include', '/')

        cy.get('.btn').contains(' Registracija kot ponudnik storitev ')
            .click()

        cy.url()
            .should('include', '/signup/izvajalec')

        cy.get('.name')
            .type('Test')
            .should('have.value', 'Test')

        cy.get('.lastname')
            .type('Testko')
            .should('have.value', 'Testko')

        cy.get('.username')
            .type('testko')
            .should('have.value', 'testko')

        cy.get('.email')
            .type('test@gmail.com')
            .should('have.value', 'test@gmail.com')

        cy.get('.password1')
            .type('test')
            .should('have.value', 'test')

        cy.get('.password2')
            .type('test')
            .should('have.value', 'test')

        // cy.get('[type="radio"]').contains('Izvajalec storitve').click()

        cy.get('.btn-primary')
            .click()
        cy.wait(500)



        cy.get('h1').contains('PRIJAVA')
    });
});
