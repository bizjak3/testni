describe("Neuspešna prijava uporabnika", function () {
    it('Obisk strani prijava in neuspešna prijava', function () {
        cy.visit('http://localhost:4200/login')

        cy.url()
            .should('include', '/login')

        cy.get('.email')
            .type('miro1')
            .should('have.value', 'miro1')

        cy.get('.password')
            .type('miro')
            .should('have.value', 'miro')

        cy.get('.btn-primary')
            .click()
        cy.wait(500)

        cy.get('.alert').contains('Napaka pri prijavi')
    });
})
