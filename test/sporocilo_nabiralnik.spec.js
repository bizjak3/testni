describe('Dodajanje nove storitve z napako', function () {
    it('Obisk strani za dodajanje in dodajenje', function () {
        cy.visit('http://localhost:4200/login')

        cy.url()
            .should('include', '/login')

        cy.get('.email')
            .type('lastničko')
            .should('have.value', 'lastničko')

        cy.get('.password')
            .type('lastnik')
            .should('have.value', 'lastnik')

        cy.get('.btn-primary')
            .click()
        cy.wait(500)

        cy.get('.btn').contains('Sporočila')
            .click()
        cy.wait(500)

        cy.get('.btn').contains('testko')
            .click()
        cy.wait(500)


        cy.get('h6').contains('Pozdravljen pasjehodec')

    });
});
