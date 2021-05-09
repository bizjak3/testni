describe("Prijava registriranega uporanika", function () {
    it('Visit login page and login', function () {
        cy.visit('http://localhost:4200/login')

        cy.url()
            .should('include', '/login')

        cy.get('.email')
            .type('mnovak1')
            .should('have.value', 'mnovak1')

        cy.get('.password')
            .type('care')
            .should('have.value', 'care')

        cy.get('.btn-primary')
            .click()
    });
})
