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
            .type('Bor')
            .should('have.value', 'Bor')

        cy.get('.lastname')
            .type('Novak')
            .should('have.value', 'Novak')

        cy.get('.username')
            .type('bornovak')
            .should('have.value', 'bornovak')

        cy.get('.email')
            .type('bornovak@gmail.com')
            .should('have.value', 'bornovak@gmail.com')

        cy.get('.password1')
            .type('borbor')
            .should('have.value', 'borbor')

        cy.get('.password2')
            .type('borbor')
            .should('have.value', 'borbor')

        // cy.get('[type="radio"]').contains('Izvajalec storitve').click()

        cy.get('.btn-primary')
            .click()
        cy.wait(500)



        cy.get('h1').contains('PRIJAVA')
    });
});
