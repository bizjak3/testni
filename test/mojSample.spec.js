describe("First try", function () {
    it('Type in email and password', function () {
        cy.visit('http://localhost:4200/login')

        cy.contains('Email')
        cy.contains('Geslo')
        cy.contains('Prijava')
        cy.contains('Registracija')
        cy.contains('PRIJAVA')

        cy.url()
            .should('include', '/login')

        cy.get('.email')
            .type('fake@mail.com')
            .should('have.value', 'fake@mail.com')

        cy.get('.password')
            .type('fakePassword')
            .should('have.value', 'fakePassword')

        cy.get('.btn-primary')
            .click()
    });
})
